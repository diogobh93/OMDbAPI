# Aplicativo OmdbAPI HTTP RESTfull
Busca informações sobre filmes.

1) Gradle.app

* Inserida em dependencies as bibliotecas:
* implementation 'com.android.volley:volley:1.1.1'
* implementation 'com.squareup.picasso:picasso:2.71828'

2) AndroidManifest.xml
* Adicionado permissões para que seja possível operações de rede.

3) Tela MainActivity

* Foi criado uma interface simples com elementos ImageView, TextView, EditText e um Button.
* Utilizado a biblioteca Volley para as requisições HTTP juntamente com a API OMDb que é um serviço Web RESTful para obter informações de filmes.
* Dados de resposta da requisição de pesquisa de filme, foram convertidos em JSON para a manipulação dos dados.
* Validações do campo EdiText e resposta de requisição de busca.
* Criado intent para trocar informações entre as telas.

4) Tela FilmesActivity

* Interface simples com Imageview e Textview.
* Utilizado a biblioteca Picasso para carregar a foto via url no ImageView.
* Criado Bundle para a recuperação dos dados enviado na transação de tela via intent.
* Verificação simples se há url de imagem recuperada da API Omdb, caso seja "N/A" será inserida uma imagem com a informação sem foto.

# Imagens
![tela1](https://user-images.githubusercontent.com/37723303/54823435-9b84a180-4c86-11e9-92bd-ffd93bdedfcf.jpg)
![tela2](https://user-images.githubusercontent.com/37723303/54823688-5ad95800-4c87-11e9-98b2-4b169c533d79.jpg)
