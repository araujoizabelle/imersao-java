import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {
    public List<Conteudo> extrairConteudos(String json) {
        var parser = new JsonParser();
        // <key, value>

        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImages = atributos.get("url");

            var conteudo = new Conteudo(titulo, urlImages);

            conteudos.add(conteudo);
        }

        return conteudos;

    }
}
