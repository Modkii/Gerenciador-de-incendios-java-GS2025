Gerenciador de Incêndios - GS2025

Sistema desenvolvido para monitoramento, registro e gestão de ocorrências de incêndios florestais. O projeto integra a disciplina interdisciplinar Global Solution do curso de Análise e Desenvolvimento de Sistemas, com foco na aplicação de tecnologias modernas para solução de problemas reais.

📂 Estrutura do Projeto

O projeto está organizado seguindo boas práticas de separação de responsabilidades:

src/
└── br/
    └── com/
        └── queimadas/
            ├── Main.java
            ├── models/
            │   └── Incendio.java
            ├── services/
            │   └── GerenciadorIncendios.java
            └── utils/
                └── LeitorDados.java

🚀 Funcionalidades

Cadastro e armazenamento de focos de incêndio com dados como localização e intensidade

Monitoramento de áreas afetadas

Geração de relatórios estatísticos

Interface por linha de comando para interação simples e direta

⚒️ Tecnologias Utilizadas

Java 17

Maven (gerenciador de dependências)

JUnit (testes unitários)

📦 Como Executar o Projeto

Clone o repositório:

git clone https://github.com/Modkii/Gerenciador-de-incendios-java-GS2025.git

Acesse o diretório do projeto:

cd Gerenciador-de-incendios-java-GS2025

Compile o projeto com Maven:

mvn compile

Execute a aplicação:

mvn exec:java -Dexec.mainClass="br.com.queimadas.Main"


👥 Integrantes

Gabriel Matias Simões - RM: 556171

Nathan Craveiro - RM: 555508

Miguel Carmo - RM: 557622
