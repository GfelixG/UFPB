package POO.artesanato;

import java.util.*;

public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{

    private Map<String, ItemDeArtesanato> itensDeArtesanato;

    public SistemaFeiraArtesanatoRioTinto(){
        this.itensDeArtesanato = new HashMap<>();
    }

    @Override
    public boolean cadastraItem(ItemDeArtesanato item) {
        if (this.itensDeArtesanato.containsKey(item.getCodigo())){
            return false;
        } else {
            this.itensDeArtesanato.put(item.getCodigo(), item);
            return true;
        }
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome) {
        List<ItemDeArtesanato> itensPeloNome = new LinkedList<>();
        for (ItemDeArtesanato item: this.itensDeArtesanato.values()){
            if (item.getNome().startsWith(nome)){
                itensPeloNome.add(item);
            }
        }
        Collections.sort(itensPeloNome);
        return itensPeloNome;
    }

    @Override
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco) {
        List<ItemDeArtesanato> itensPorPreco = new LinkedList<>();
        for (ItemDeArtesanato item: this.itensDeArtesanato.values()){
            if (item.getPreco()<= preco){
                itensPorPreco.add(item);
            }
        }
        Collections.sort(itensPorPreco);
        return itensPorPreco;
    }

    @Override
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteException {
        ItemDeArtesanato item = this.itensDeArtesanato.get(codigo);
        if (item == null){
            throw new ItemInexistenteException("Não existe item com o código "+codigo);
        } else {
            return item;
        }

    }
}
