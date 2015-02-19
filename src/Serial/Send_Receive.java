package Serial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier; 
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.TooManyListenersException;


public class Send_Receive implements SerialPortEventListener {
    
    SerialPort serialPort;
    String Information;
    String TAG_UID[];
    String statusLog;

    public Send_Receive() {
        this.Information = "";
    }
    
    
    
    /** The port we're normally going to use. */
    private static final String PORT_NAMES[] = { 
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };//END StringArray
    
    /**
    * A BufferedReader which will be fed by a InputStreamReader 
    * converting the bytes into characters 
    * making the displayed results codepage independent
    */
    private BufferedReader input;
    /** The output stream to the port */
    private OutputStream output;
    /** Milliseconds to block while waiting for port open */
    private static final int TIME_OUT = 2000;
    /** Default bits per second for COM port. */
    private static final int DATA_RATE = 19200;

    public void initialize() {
        // the next line is for Raspberry Pi and 
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        //System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }//END IF getName()
            }//END FOR(portName)
        }//END WHILE(portEnum)
        
        
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }//END IF (portId)

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println(e.toString());
        }//END TRY/CATCH
    }//END initialize()

    public String getInformation() {
        return Information;
    }

    public void setInformation(String Information) {
        this.Information = Information;
    }

    public String[] getTAG_UID() {
        return TAG_UID;
    }

    public void setTAG_UID(String[] TAG_UID) {
        this.TAG_UID = TAG_UID;
    }

    public String getStatusLog() {
        return statusLog;
    }

    public void setStatusLog(String statusLog) {
        this.statusLog = statusLog;
    }

    /**
     * This should be called when you stop using the port.
     * This will prevent port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }//END IF (serialPort)
    }//END close()

    /**
    * Handle an event on the serial port. Read the data and print it.
    * @param oEvent
    */
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            Information = serialIn();
        }
    }//END serialEvent()
    
    public synchronized String serialIn() {
        try {
                System.out.println("Leyendo datos del puerto serie...");
                String information = input.readLine();
                System.out.println(information);
                splitInfo(information);
                MonitorAcceso.Consola.append(information+"\n");
                return information;
            } catch (Exception e) {
                    this.Information = "";
                    System.err.println(e.toString());
                    return "";
            }//END TRY/CATCH
    }//END serialIn()
    
    public synchronized void serialOut(char info) {
        try {
            System.out.println("Enviando datos...");
            output.write(info);
        } catch (Exception e) {
            System.err.println(e.toString());
        }//END TRY/CATCH
    }//END serialOut()
    
    private void splitInfo(String nfo) {
        String[] seccionInfo = nfo.split(":");
        statusLog = seccionInfo[5];
        String TAG_UI[] = {
            seccionInfo[1],
            seccionInfo[2],
            seccionInfo[3],
            seccionInfo[4]
        };
        TAG_UID  = TAG_UI;
    }//END splitInfo()
}//END CLASS