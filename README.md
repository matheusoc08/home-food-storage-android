Criar um controle de estoque dos alimentos e outros produtos da casa.

Também criar uma lista de compras que recebe os produtos e quantidade ou grama.

API: https://github.com/matheusoc08/home-food-storage-api
Design v1: https://www.figma.com/file/Ny4oasuNqIuSkaT0Lz0bIx/Untitled?node-id=1%3A26&t=FQQHzOQLCCTwvMt5-1

# Estoque
Deve conter:
- string NomeProduto,
- string Descrição,
- double PesoUnidade,
- int Quantidade,
- decimal Valor

## Todo

### FRONT
- Tela inicial
- [ ] Exibir todos os itens na página inicial
- [ ] Conter barra de pesquisa
- [ ] A barra de pesquisa deve retornar os itens na tela inicial conforme o campo é preenchido.

- Tela para inclusao/Tela para alteração
- [ ] Exibir campos Nome, Descricao, Peso, Quantidade, Preco e Comprado.
- [ ] Conter botão para confirmar e outro para cancelar ação.

- Remoção de item
- [ ] Incluir botão para remoção de item
- [ ] Exibir um toast informando que o item foi removido.

# Lista de compras
Deve conter:
- string NomeProduto,
- string Descrição,
- double PesoUnidade,
- int Quantidade,
- decimal Valor,
- boolean Comprado

## Todo

### FRONT
- Tela inicial
- [x] Exibir uma lista com todos os itens na página inicial
- [x] Conter uma barra de pesquisa
- [x] Checkbox para marcar ou desmarcar a compra do item
- [x] Botão para incluir os itens comprados no estoque
- [x] Popup de "confirmação" ao clicar em enviar lista ao estoque
- [x] Botão para limpar a lista
- [x] Mensagem de "lista vazia" quando não houver itens cadastrados

- Tela para inclusao
- [x] Exibir campos Nome, Descricao, Peso, Quantidade, Preco e Comprado
- [x] Conter botão para confirmar inclusão
- [x] Popup para confirmar a edição do item
- [x] Exibir um toast informando que o item foi alterado e retornar para a tela inicial

- Tela para alteração
- [x] Exibir campos Nome, Descricao, Peso, Quantidade, Preco e Comprado
- [x] Conter botão para confirmar inclusão/alteração
- [x] Botão para excluir o item selecionado
- [x] Popup para confirmar a exclusão do item
- [x] Exibir um toast informando que o item foi removido e retornar para a tela inicial

### BACK
- [ ] A barra de pesquisa deve retornar os itens pesquisados na tela inicial conforme o campo é preenchido.
- [x] Configuração para utilizar o SQLite do aparelho
- [x] Método para incluir um item em uma tabela
- [x] Método para editar um item da tabela
- [x] Método para excluir um item da tabela
- [x] Método para excluir todos os itens da tabela
- [ ] Realizar tratamento de erros


