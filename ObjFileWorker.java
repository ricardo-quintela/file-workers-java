package files;

import java.io.*;

/**
 * <h1>OBJECT FILE WORKER</h1>
 * <p>This class can be used to easily operate with object files</p>
 * <p>The programmer can then save and load an object to a file with ease</p>
 *
 * @author Ricardo Quintela
 */
public class ObjFileWorker {
    private File f;

    /**
     * Default constructor
     */
    public ObjFileWorker() {
    }


    /**
     * Constructor
     *
     * @param path the path to the file
     */
    public ObjFileWorker(String path) {
        this.f = new File(path);
    }


    /**
     * Access the file
     *
     * @return the file
     */
    public File getF() {
        return f;
    }

    /**
     * Define the file
     *
     * @param path the file
     */
    public void setF(String path) {
        this.f = new File(path);
    }


    @Override
    public String toString() {
        return "Ficheiro em" + f;
    }


    /**
     * Save an object on the file if it exists
     *
     * @param o the Object to save on the file
     */
    public void write(Object o) {

        //open buffers and write on the file
        try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(this.f))) {
            //write the object on the file
            oOS.writeObject(o);

        } catch (IOException e) {
            System.out.println("Erro! Ocorreu um erro ao escrever o objecto no ficheiro");
        }
    }

    /**
     * Reads the objects on the file
     *
     * @return the file contents
     */
    public Object read() {
        //only read if the file exists
        if (!this.f.exists()) {
            System.out.println("Erro! Ocorreu um erro ao ler os dados guardados!");
            return null;
        }

        Object o = null;
        //open buffers and read the file
        try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(this.f))) {
            //write the text on the file
            o = oIS.readObject();

        } catch (ClassNotFoundException e) {
            o = null;
            System.out.println("Erro! Classe nao exixte!");

        } catch (IOException e) {
            o = null;
            System.out.println("Erro! Ocorreu um erro a ler o ficheiro!");

        }

        return o;
    }

}
