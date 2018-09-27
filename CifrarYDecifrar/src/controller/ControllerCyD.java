package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import model.ModelCyD;
import view.ViewCyD;

public class ControllerCyD implements ActionListener
{
    private final ModelCyD modelCyD;
    private final ViewCyD viewCyD;
    FileFilter filtro = new FileNameExtensionFilter("simon si jamlo", "simon si jalo");

    public ControllerCyD(ViewCyD viewCyD, ModelCyD modelCyD)    
    {
        this.viewCyD = viewCyD;
        this.modelCyD = modelCyD;
        viewCyD.jmi_abrir.addActionListener(this);
        viewCyD.jmi_guardar.addActionListener(this);
        viewCyD.jmi_cifrar.addActionListener(this);
        viewCyD.jmi_decifrar.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewCyD.jmi_abrir){
            JFileChooser file=new JFileChooser(); //Crea el objeto para el filechooser
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null); //Carga la ventana de dialogo y encuentra la ruta donde almacenamos el archivo 
            modelCyD.readFile(modelCyD.getPath()); //abre el archivo obteniendo la ruta desde el modelo
            viewCyD.jta_txt.setText(modelCyD.getMessage()); //muestra el contenido en el JTextArea
        }else if(e.getSource()==viewCyD.jmi_guardar){
            JFileChooser file=new JFileChooser();
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modelCyD.setPath(""+file.getSelectedFile());
            modelCyD.setMessage(viewCyD.jta_txt.getText());
            modelCyD.writeFile(modelCyD.getPath(), modelCyD.getMessage());
        }else if(e.getSource()==viewCyD.jmi_cifrar){
            JFileChooser file=new JFileChooser(); 
            file.addChoosableFileFilter(filtro);
            file.showSaveDialog(null);
            modelCyD.setPath(""+file.getSelectedFile());
            modelCyD.setMessage(viewCyD.jta_txt.getText());
            modelCyD.writeFileEncrypted(modelCyD.getPath(), modelCyD.getMessage());
        }else if(e.getSource()==viewCyD.jmi_decifrar){
            JFileChooser file=new JFileChooser(); 
            file.addChoosableFileFilter(filtro);
            file.showOpenDialog(null);
            modelCyD.readFileDecrypted(modelCyD.getPath());
            viewCyD.jta_txt.setText(modelCyD.getMessage()); //muestra el contenido en el JTextArea
        }
    }
    private void initView() 
    {
        viewCyD.setTitle("Archivo!");
        viewCyD.setResizable(false);
        viewCyD.setLocationRelativeTo(null);
        viewCyD.setVisible(true);
    }
}