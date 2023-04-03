import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        var http = new ClienteHttp();

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String jsonConteudos = http.buscarDados(url);
        ExtratorDeConteudo extratorImdb = new ExtratorDeConteudoImdb();
        List<Conteudo> conteudos = extratorImdb.extrairConteudos(jsonConteudos);

        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";

        // String jsonConteudos = http.buscarDados(url);

        // ExtratorDeConteudo extratorNasa = new ExtratorDeConteudoNasa();
        // List<Conteudo> conteudos = extratorNasa.extrairConteudos(jsonConteudos);

        var diretorio = new File("figurinhas/");
        diretorio.mkdir();

        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "figurinhas/" + conteudo.getTitulo() + ".png";

            var geradora = new GeradorDeFigurinhas();
            geradora.gerarFigurinha(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
