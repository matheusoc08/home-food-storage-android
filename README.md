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
- [x] Exibir todos os itens na página inicial
- [x] Conter barra de pesquisa
- [ ] A barra de pesquisa deve retornar os itens na tela inicial conforme o campo é preenchido.
- [x] Checkbox para marcar ou desmarcar a compra do item
- [x] Botão para incluir os itens comprados no estoque
- [x] Botão para limpar a lista

- Tela para inclusao/Tela para alteração
- [x] Exibir campos Nome, Descricao, Peso, Quantidade, Preco e Comprado.
- [ ] Conter botão para confirmar e outro para cancelar ação.

- Remoção de item
- [ ] Incluir botão para remoção de item.
- [ ] Exibir um toast informando que o item foi removido.

