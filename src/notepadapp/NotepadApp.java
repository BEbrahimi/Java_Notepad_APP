package notepadapp;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
public class NotepadApp  extends JFrame implements ActionListener {
    
    JMenuBar menubar = new JMenuBar();
    
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
//   it is for file menue item 
    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem printFile = new JMenuItem("Print");
    JMenuItem exitFile = new JMenuItem("exit");
    
    //   it is for Edit menue item 
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    
    //   it is for help menue item   
    JMenuItem about = new JMenuItem("About");
    
    JTextArea textArea = new JTextArea();
    
    
    
    

        NotepadApp()
    {
        setTitle("Notepad Application");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        ImageIcon icon = new ImageIcon(getClass().getResource("notepad.png"));
        setIconImage(icon.getImage());
        
        setJMenuBar(menubar);
        
//        add(menubar);
        menubar.add(file);
        menubar.add(edit);
        menubar.add(help);
  
        
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(printFile);
        file.add(exitFile);
        
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        
        help.add(about);
        
        JScrollPane scrollpen = new JScrollPane(textArea);
        add(scrollpen);
        
        scrollpen.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpen.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        exitFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
        
  
          
        
    } 
    public static void main(String[] args) {
       new NotepadApp().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    
   if(e.getActionCommand().equalsIgnoreCase("New"))
   {
       textArea.setText(null);   
   }else if(e.getActionCommand().equalsIgnoreCase("Open"))
   {
      JFileChooser filechooser = new JFileChooser();
       FileNameExtensionFilter textfilter =new FileNameExtensionFilter("Only test files", "txt");
       filechooser.setAcceptAllFileFilterUsed(false);
       filechooser.addChoosableFileFilter(textfilter);
       
       int action = filechooser.showOpenDialog(null);
       if (action != JFileChooser.APPROVE_OPTION) {
           return;
       }else
       {
             try {
                   BufferedReader reader= new BufferedReader(new FileReader(filechooser.getSelectedFile()));
                   textArea.read(reader,null);
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
                
       }
       
       
   }else if(e.getActionCommand().equalsIgnoreCase("Save"))
   {
       JFileChooser filechooser = new JFileChooser();
       FileNameExtensionFilter textfilter =new FileNameExtensionFilter("Only test files", "txt");
       filechooser.setAcceptAllFileFilterUsed(false);
       filechooser.addChoosableFileFilter(textfilter);
       
       int action = filechooser.showSaveDialog(null);
       if (action != JFileChooser.APPROVE_OPTION) {
           return;
       }else{
           String fileName = filechooser.getSelectedFile().getAbsolutePath().toString();
           
           if (!fileName.contains(".txt")) {
               fileName = fileName + ".txt";
               try {
                   BufferedWriter writer= new BufferedWriter(new FileWriter(fileName));
                   textArea.write(writer);
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
                
           }
       }
       
       
   }else if(e.getActionCommand().equalsIgnoreCase("Print"))
   {
       try {
           textArea.print();
       } catch (PrinterException ex) {
           java.util.logging.Logger.getLogger(NotepadApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       
   }
   else if(e.getActionCommand().equalsIgnoreCase("Exit"))
   {
       System.exit(0);
   }
   else if(e.getActionCommand().equalsIgnoreCase("Cut"))
   {
       textArea.cut();
   }
   else if(e.getActionCommand().equalsIgnoreCase("Copy"))
   {
       textArea.copy();
   }
    else if(e.getActionCommand().equalsIgnoreCase("Paste"))
   {
       textArea.paste();
   }
    else if(e.getActionCommand().equalsIgnoreCase("Select All"))
   {
       textArea.selectAll();
   }
   
    else if(e.getActionCommand().equalsIgnoreCase("About"))
   {
       new About().setVisible(true);
   }
   
    
    }
    
}
