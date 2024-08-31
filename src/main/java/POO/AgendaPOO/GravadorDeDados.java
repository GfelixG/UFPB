package POO.AgendaPOO;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {
    public static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> RecuperarContatos() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))){
            return (HashMap<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e){
            throw new IOException(e);
        }
    }

    public void SalvarContatos (HashMap<String, Contato> contatos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))){
            out.writeObject(contatos);
        }
    }
}
