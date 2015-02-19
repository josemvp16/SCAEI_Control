/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serial;

import java.awt.Dimension;
import javax.swing.WindowConstants;

/**
 *
 * @author J.Israel
 */
public class Main {

    public static void main(String[] args) throws Exception {
        MonitorAcceso monitorAcceso = new MonitorAcceso();
        monitorAcceso.setTitle("SCAEI - ITESA ver.1.0");
        monitorAcceso.setSize(new Dimension(416,334));
        monitorAcceso.setLocationRelativeTo(null);
//        monitorAcceso.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        monitorAcceso.setVisible(true);
    }//END main()
    
}//END CLASS
