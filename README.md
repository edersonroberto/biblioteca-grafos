# Biblioteca de Grafos - Disciplina Teoria da Computação

## Sobre o projeto:

Nesse projeto foi implementado uma biblioteca para teoria de grafos, contendo estruturas de dados e algoritmos para representar e processar grafos. A biblioteca implementada possui as seguintes funcionalidades relacionadas abaixo, de forma fácil e prática para que possa ser utilizada por outros desenvolvedores:
* Representação de grafos direcionados ou não, com peso ou não;
* Implementação dos algoritmos:
   * Cálculo da distância de uma rota;
   * Busca em profundidade e busca em largura;
   * Algoritmo de Dijkstra para encontrar o menor caminho de um vértice para os demais vértices;
   * Algoritmos de Prim e Kruskal para obtenção de árvore/floresta geradora mínima.


## Para Rodar o Projeto:

**Eclipse Luna** - o eclipse precisa ter o maven e o github instalados como plugins. O eclipse luna já vem com ambos não sendo necessário a instalação.

**Apache Tomcat** - O tomcat será necessário para rodar o projeto web.

## Definições:

**Maven:** É o gerenciador de dependerias da aplicação.

**GitHub:** É uma ferramenta de versionamento e permite que mais de uma pessoa trabalhe em um projeto.

**Tomcat:** É uma mini servidor que roda o projeto web, precisa ser instalado no eclipse.


## Classes do Projeto:

**Aresta** - Classe responsável por abstrair uma aresta do grafo. Composta por um vértice origem um vértice destino e o peso da conexão dos dois.

**Grafo** - Classe responsável por abstrair um grafo. Contém uma lista de vértices, uma lista de arestas e uma matriz de adjacência.

**Busca** - Classe responsável por realizar uma busca em um grafo. Possui dois métodos: busca por largura e busca por profundidade.

**Busca por Largura** - recebe um grafo como parâmetro, a origem e o destino da busca. Utiliza o vértice origem como vértice atual (ponto de partida) e usa a matriz de adjacência para achar os vizinhos do vértice atual da função.  Em cada iteração o vértice atual é trocado até que o vértice vizinho seja encontrado ou todos os vértices tenham sido visitados.

**Busca por profundidade** - recebe um grafo como parâmetro, a origem e o destino da busca. Utiliza o vértice origem como vértice atual (ponto de partida) e usa a matriz de adjacência para achar os vizinhos do vértice atual da função.  Em cada iteração o vértice atual é trocado até que o vértice vizinho seja encontrado ou todos os vértices tenham sido visitados.

**Diskstra** - Classe responsável por implementar o método de descoberta do menor caminho.
Menor Caminho: recebe um grafo como parâmetro, a origem e o destino da busca. Utiliza uma tabela de distância e uma de vértices anteriores e à medida que o método é executado atualiza as tabelas, no final verifica se o vértice destino tem anterior e calcula o caminho e as distância do caminho percorrido.

**Prim** -  Classe responsável por implementar o método para descobrir a arvore gerado mínima de um grafo, utilizando o algoritmo de prim.

**Árvore geradora mínima** - Utiliza a lista de arestas para esse método. Cria uma lista de visitados e adiciona os vértices da arvore a medida que o método é executado. Faz esse loop até que a lista de visitados tenha o mesmo tamanho que a lista de vértices do grafo, isso é feito para garantir que todos os vértices do grafo estejam na arvore.

**Kruskal** - Classe responsável por implementar o método para descobrir a arvore gerado mínima de um grafo, utilizando o algoritmo de Kruskal. 

**Distância** - Classe responsável por calcular a distância de caminho. O método os vértices do caminho e calcula a distância entre o primeiro vértice e o ultimo passando por todos os vértices do caminho determinado.   

**Arbor js** - Biblioteca em jquery utilizada para visualização de grafos.

[Biblioteca Arbor no GitHub](https://github.com/samizdatco/arbor)

[Demonstração da Biblioteca no Site Oficial](http://arborjs.org/)
