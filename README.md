# PCMania

## Identificação Acadêmica

- Nome: Maria Eduarda Constância Rocha Moreira
- Matrícula: 710
- Curso: Engenharia de Software

## Documentação da Solução

A solução implementa um fluxo de compra em terminal para seleção de promoções de computadores, associação das instâncias selecionadas a um cliente e fechamento com cálculo do total.

## Estrutura do Projeto

- Linguagem: Java
- Build: Maven
- Entrada principal: [pcmania/src/main/java/pcmania/Main.java](pcmania/src/main/java/pcmania/Main.java)

### Principais classes

- [pcmania/src/main/java/pcmania/Main.java](pcmania/src/main/java/pcmania/Main.java): fluxo principal da aplicação (entrada do usuário, seleção de promoções e fechamento da compra).
- [pcmania/src/main/java/pcmania/computador/Computador.java](pcmania/src/main/java/pcmania/computador/Computador.java): entidade de computador, cadastro estático de promoções e exibição de configurações.
- [pcmania/src/main/java/pcmania/cliente/Cliente.java](pcmania/src/main/java/pcmania/cliente/Cliente.java): dados do cliente, associação de múltiplos computadores e cálculo do total.
- [pcmania/src/main/java/pcmania/hardware/HardwareBasico.java](pcmania/src/main/java/pcmania/hardware/HardwareBasico.java): componente de hardware básico.
- [pcmania/src/main/java/pcmania/hardware/MemoriaUSB.java](pcmania/src/main/java/pcmania/hardware/MemoriaUSB.java): acessório opcional de memória USB.
- [pcmania/src/main/java/pcmania/sistema/SistemaOperacional.java](pcmania/src/main/java/pcmania/sistema/SistemaOperacional.java): sistema operacional do computador.
- [pcmania/src/main/java/pcmania/utils/ProcessarPedidos.java](pcmania/src/main/java/pcmania/utils/ProcessarPedidos.java): etapa final de processamento do pedido.

## Regras Implementadas

1. O cliente deve comprar no mínimo 2 computadores para finalizar.
2. O cliente pode adicionar múltiplos computadores ao carrinho.
3. O total da compra é calculado pela soma dos preços dos computadores adicionados.
4. As promoções cadastradas são exibidas antes da escolha do usuário.

## Ajustes Aplicados na Solução

### Exibição de promoções

- O controle de promoções registradas foi corrigido com incremento do contador interno após cada cadastro.
- A listagem de promoções passou a refletir corretamente os itens registrados.
- A revisão por IA indicou separar responsabilidades de exibição: mostraPCConfigs ficou responsável por iterar promoções e delegar a impressão detalhada para mostraDetalhesPromocoes.

### Padronização de saída

- A numeração visual das promoções foi ajustada para iniciar em 1 na saída para o usuário.

### Associação cliente-computadores

- A associação foi mantida com múltiplas instâncias de Computador por cliente usando array e controle de quantidade.
- O cálculo do total utiliza apenas os computadores efetivamente adicionados.

### Organização da classe Main

- As instâncias de promoções foram inicializadas fora do bloco do-while, evitando recriação de objetos a cada iteração.
- O laço principal passou a focar apenas em interação com o usuário e seleção de promoções já cadastradas.

## Prompt de Revisão de Código

### Prompt utilizado

Realize uma revisão técnica completa do projeto Java, com foco no fluxo de execução da listagem de promoções, validação de estado interno e consistência entre cadastro e exibição. A revisão deve obrigatoriamente incluir conferência com o PDF de referência enviado, garantindo aderência entre implementação e especificação. Identifique causas de falha lógica que não geram erro de compilação e proponha correção mínima, objetiva e segura, preservando a estrutura orientada a objetos existente. Avalie também oportunidades de melhora da organização do código, incluindo a separação da lógica.
### Resultado da revisão

- Foi identificado e corrigido um ponto de controle de estado que impedia a exibição das promoções cadastradas.
- A solução foi validada por compilação com Maven e mantida sem alteração arquitetural desnecessária.

### Principais erros encontrados

- Contador de promoções não incrementado após registro, impedindo a exibição em mostraPCConfigs.
- Divergência de apresentação na saída: promoções numeradas a partir de 0, corrigida para iniciar em 1.
- Ausência de proteção contra extrapolação do limite do array estático de promoções em cenários com mais de 10 registros.

## Como Executar

Na pasta [pcmania](pcmania):

1. Compilar:
	mvn clean compile
2. Executar:
	mvn exec:java -Dexec.mainClass="pcmania.Main"

## Autoria do Documento

Este README foi gerado com apoio do GitHub Copilot, utilizando o modelo GPT-5.3-Codex, com revisão final do autor do projeto.