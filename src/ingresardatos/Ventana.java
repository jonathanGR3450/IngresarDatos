
package ingresardatos;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import Personas.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;




public class Ventana {
    private JFrame ventana=new JFrame("ingresar Datos");
    private int click=0;
    private String g="";
    private Object objpersonas[]=new Object [5]; 
    private String l="";
    
    private String JRadioButton[]={"Sistemas","Electronica","Agroindutrial","Agronomia"};
    private String emple[]={"ejecutivo","gerente","desarrollador","administrador"};
    
    
    private JRadioButton persona=new JRadioButton("Persona");
    private JRadioButton estudiante=new JRadioButton("Estudiante");
    private JRadioButton empleado=new JRadioButton("Empleado");
    
    private JLabel id=new JLabel("Identificacion");
    private JTextField ide=new JTextField("");
    private JLabel nombre=new JLabel("Nombres");
    private JTextField nomb=new JTextField("");
    private JLabel apellido=new JLabel("Apellidos");
    private JTextField apellid=new JTextField("");
    
    private JLabel codigo=new JLabel("Codigo");
    private JTextField codig=new JTextField("");
    private JLabel programa=new JLabel("Programa");
    private JComboBox progra=new JComboBox(JRadioButton);
    
    private JLabel fecha=new JLabel("Fecha Ingreso");
    private JTextField fechai=new JTextField(" ");
    
    private JLabel cargo=new JLabel("Cargo");
    private JComboBox empleo=new JComboBox(emple);
    
    private JLabel salario=new JLabel("Salario");
    private JTextField sueldo=new JTextField("");
    private JLabel fecha1=new JLabel("Fecha Ingreso");
    private JTextField fecha2=new JTextField("");
    
    private JButton guardar=new JButton("GUARDAR");
    private JButton limpiar=new JButton("LIMPIAR");
   
    private JPanel conp=new JPanel();
    private JPanel uno=new JPanel();
    private JPanel dos=new JPanel();
    private JPanel tres=new JPanel();
    private JPanel cuatro=new JPanel();
    
    public Ventana(){
        ventana.setSize(400,700);
       ventana.setLayout(new GridLayout(5,1));
       
       ButtonGroup grupo=new ButtonGroup();
       grupo.add(persona);
       grupo.add(estudiante);
       grupo.add(empleado);
       
       
       
        conp.setLayout(new FlowLayout());
        conp.add(persona);
        conp.add(estudiante);
        conp.add(empleado);
        
        ventana.add(conp);
        
        uno.setLayout(new GridLayout(4,2));
        uno.add(id);
        uno.add(ide);
        uno.add(nombre);
        uno.add(nomb);
        uno.add(apellido);
        uno.add(apellid);
        ventana.add(uno);
        dos.setLayout(new GridLayout(4,2));
        dos.add(codigo);
        dos.add(codig);
        dos.add(programa);
        dos.add(progra);
        dos.add(fecha);
        dos.add(fechai);
        ventana.add(dos);
        
        tres.setLayout(new GridLayout(4,2));
        tres.add(cargo);
        tres.add(empleo);
        tres.add(fecha1);
        tres.add(fecha2);
        tres.add(salario);
        tres.add(sueldo);
        ventana.add(tres);
        
        cuatro.setLayout(new FlowLayout());
        cuatro.add(guardar);
        cuatro.add(limpiar);
        ventana.add(cuatro);
        
        ActionListener a2=new ActionListener(){
           public void actionPerformed(ActionEvent ev){
              codig.setEnabled(false);
              progra.setEnabled(false);
              fechai.setEnabled(false);
           }
        };
        ActionListener a21=new ActionListener(){
           public void actionPerformed(ActionEvent ev){
              codig.setEnabled(true);
              progra.setEnabled(true);
              fechai.setEnabled(true);
           }
        };
        
        ActionListener a1=new ActionListener(){
            public void actionPerformed(ActionEvent ev){
              ide.setEnabled(true);
              nomb.setEnabled(true);
              apellid.setEnabled(true);
            }
        };
        
        
        ActionListener a3=new ActionListener(){
            public void actionPerformed(ActionEvent ev){
              empleo.setEnabled(false);
              sueldo.setEnabled(false);
              fecha2.setEnabled(false);
            }
        };
        ActionListener a31=new ActionListener(){
            public void actionPerformed(ActionEvent ev){
              empleo.setEnabled(true);
              sueldo.setEnabled(true);
              fecha2.setEnabled(true);
            }
        };
        
        ide.setEnabled(false);
        nomb.setEnabled(false);
        apellid.setEnabled(false);
        codig.setEnabled(false);
        progra.setEnabled(false);
        fechai.setEnabled(false);
        empleo.setEnabled(false);
        sueldo.setEnabled(false);
        fecha2.setEnabled(false);
        
        
        persona.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ev){
                if (ev.getStateChange()==ItemEvent.SELECTED){
                    persona.addActionListener(a1);
                    persona.addActionListener(a2);
                    persona.addActionListener(a3);
                } else {
                    persona.addActionListener(a1);
                    persona.addActionListener(a21);
                    persona.addActionListener(a31);
                }
                
                guardar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ev){
                        Persona ej=new Persona();
                        if(nomb.getText()!="")
                        ej.setNombres(nomb.getText()); 
                        if(apellid.getText()!="")
                        ej.setApellidos(apellid.getText());
                        
                        if (ide.getText()!=""){
                    try {
                        Double.parseDouble(ide.getText());
                    } catch(NumberFormatException nfe){
                        ide.setText(null);
                    }
                        ej.setIdentificacion(Double.parseDouble(ide.getText()));
                        }
                    if (click<5){
                    objpersonas[click]=ej;
                    System.out.println(click);
                    }click++;
                    
                    
                    }
                });
            }
        });
        
        estudiante.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ev){
            
                if (ev.getStateChange()==ItemEvent.SELECTED){
                    estudiante.addActionListener(a1);
                    estudiante.addActionListener(a3);
                    estudiante.addActionListener(a21);
                } else {
                    estudiante.addActionListener(a1);
                    estudiante.addActionListener(a21);
                    estudiante.addActionListener(a31);
                }
                guardar.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ev){
                        progra.addItemListener(new ItemListener(){
                  public void itemStateChanged(ItemEvent ev){
                      String s=(String)progra.getSelectedItem();
                      g=s;
                  }
                    });
              if(fechai.getText()!=" "){
              SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaDat = null;
                try {
                    fechaDat = format.parse(fechai.getText());
                } 
                catch (ParseException ex) 
                {
                    ex.printStackTrace();
                }
                 if((codig.getText()!="")&&(ide.getText()!="")&&(nomb.getText()!="")&&(apellid.getText()!="")){
                 Estudiante est=new Estudiante(Double.parseDouble(codig.getText()),g,Double.parseDouble(ide.getText()),nomb.getText(),apellid.getText(),fechaDat);
                 
                 if (click<5){
                    objpersonas[click]=est;
                    System.out.println(click);
                    }click++;
                 }
              }
                    
                    }
                });
            }
        });
        
        empleado.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ev){
                if (ev.getStateChange()==ItemEvent.SELECTED){
                    empleado.addActionListener(a1);
                    empleado.addActionListener(a2);
                    empleado.addActionListener(a31);
                    
                    
                    
                } else {
                    empleado.addActionListener(a1);
                    empleado.addActionListener(a21);
                    empleado.addActionListener(a31);
                }
                
                guardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

              
              
              
              empleo.addItemListener(new ItemListener(){
                  public void itemStateChanged(ItemEvent ev){
                      String s=(String)empleo.getSelectedItem();
                      l=s;
                  }
              });
              
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDate = null;
            try {
                fechaDate = formato.parse(fecha2.getText());
            } 
            catch (ParseException ex) 
            {
                ex.printStackTrace();
            }
              
              Empleado Em=new Empleado(l,fechaDate,Double.parseDouble(sueldo.getText()),Double.parseDouble(ide.getText()),nomb.getText(),apellid.getText());
              if (click<5){
              objpersonas[click]=Em;
              System.out.println(click);
              }
              click++;
              
            } 
            
            
        });
            }
        });
 
        limpiar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                ide.setText(null);
                nomb.setText(null);
                apellid.setText(null);
                codig.setText(null);
                fechai.setText(null);
                fecha2.setText(null);
                sueldo.setText(null);
            }
        });
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
