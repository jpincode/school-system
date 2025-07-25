# Sistema de Gerenciamento Escolar

## 📝 Descrição
Sistema desenvolvido em Java para gerenciamento de alunos e disciplinas em uma instituição de ensino. O projeto implementa operações CRUD (Create, Read, Update, Delete) e segue o padrão de arquitetura MVC (Model-View-Controller). Agora, o sistema utiliza DTOs (Data Transfer Objects) para transferência de dados entre camadas e aprimora a separação de responsabilidades.

## 🏗️ Estrutura do Projeto

```
src/
├── business/
│   ├── dto/
│   │   ├── DisciplineDTO.java        # DTO para disciplina
│   │   └── StudentDTO.java           # DTO para aluno
│   └── services/
│       ├── DisciplineService.java    # Regras de negócio para disciplinas (agora usando DTO)
│       ├── IOService.java            # Serviço de entrada/saída
│       └── StudentService.java       # Regras de negócio para alunos (agora usando DTO)
├── models/
│   ├── entities/
│   │   ├── Discipline.java           # Entidade Disciplina
│   │   └── Student.java              # Entidade Aluno
│   └── repositories/
│       ├── DisciplineRepository.java # Repositório de Disciplinas
│       ├── ManagerRepository.java    # Gerenciador de Repositórios (Singleton)
│       └── StudentRepository.java    # Repositório de Alunos
└── presentations/
    ├── controllers/
    │   ├── DisciplineController.java # Controlador de Disciplinas (agora usando DTO)
    │   └── StudentController.java    # Controlador de Alunos (agora usando DTO)
    └── views/
        ├── DeleteView.java           # Interface de exclusão
        ├── ListView.java             # Interface de listagem
        ├── Main.java                 # Ponto de entrada da aplicação
        ├── MenuView.java             # Menu principal
        ├── RegisterView.java         # Interface de cadastro
        └── UpdateView.java           # Interface de atualização
```

## 🚀 Novidades e Melhorias

- **Uso de DTOs:** Agora, os dados trafegam entre camadas por meio de objetos DTO, melhorando a organização e a manutenção do código.
- **Controllers e Services atualizados:** Métodos de cadastro e atualização agora recebem DTOs como parâmetro.
- **Validações aprimoradas:** Validação de campos obrigatórios e unicidade permanece, mas agora centralizada nos DTOs e services.
- **Código mais modular:** Separação clara entre entidades, DTOs, lógica de negócio, persistência e apresentação.

## 🛠️ Tecnologias Utilizadas
- Java 17
- Padrão MVC
- Programação Orientada a Objetos
- Singleton Pattern (ManagerRepository)
- DTO Pattern

## ⚙️ Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 17 ou superior
- Visual Studio Code com extensão "Extension Pack for Java"

### Passos para Execução

1. Clone o repositório:
```bash
git clone https://github.com/jpdevv/school-system.git
```

2. Abra o projeto no Visual Studio Code:
```bash
code school-system
```

3. Compile e execute a classe Main:
```bash
cd src
javac presentations/views/Main.java
java presentations.views.Main
```

## 📱 Como Usar

### Menu Principal
O sistema apresenta as seguintes opções:
1. Cadastrar Disciplina
2. Cadastrar Aluno
3. Matricular Aluno na Disciplina
4. Excluir Disciplina
5. Excluir Aluno
6. Desmatricular Aluno da Disciplina
7. Atualizar Disciplina
8. Atualizar Aluno
9. Listar
0. Sair

### Menu de Listagem
1. Listar Disciplinas
2. Listar Alunos
0. Voltar ao Menu Principal

### Operações Principais

#### Cadastro de Aluno
- Informações necessárias:
  - Matrícula (único)
  - Nome
  - Email (único)
  - Endereço

#### Cadastro de Disciplina
- Informações necessárias:
  - Nome
  - Código (único)
  - Carga horária

## 🏗️ Arquitetura

### Camadas do Sistema
1. **Apresentação** (`presentations/`)
   - Views: Interface com usuário dividida em múltiplas views especializadas
   - Controllers: Validação de entrada e direcionamento, agora utilizando DTOs

2. **Negócio** (`business/`)
   - DTOs: Objetos de transferência de dados entre camadas
   - Services: Regras de negócio e lógica da aplicação, agora utilizando DTOs
   - IOService: Gerenciamento de entrada/saída

3. **Modelo** (`models/`)
   - Entities: Classes de domínio
   - Repositories: Persistência de dados em memória

## 👥 Padrões de Projeto Utilizados

### MVC (Model-View-Controller)
- **Model**: Entidades e repositórios
- **View**: Classes especializadas em `presentations/views`
- **Controller**: Classes em `presentations/controllers` (agora usando DTOs)

### Repository Pattern
- Abstração da persistência de dados
- Implementado em `models/repositories`
- Gerenciado pelo ManagerRepository

### Singleton Pattern
- Implementado no ManagerRepository para garantir instância única
- Centraliza o acesso aos repositórios
- Garante consistência no acesso aos dados

### DTO Pattern
- Utilizado para transferir dados entre camadas de forma desacoplada

## 🔍 Validações
- Matrícula única para alunos
- Email único para alunos
- Código único para disciplinas
- Campos obrigatórios não podem estar vazios
- Confirmação para exclusões

## 🤝 Contribuindo
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📫 Contato
- Email: joaoaraujo.developer@gmail.com
- LinkedIn: [João Paulo](https://www.linkedin.com/in/joaodevv/)
- GitHub: [jpdevv](https://github.com/jpdevv)