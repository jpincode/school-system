# Sistema de Gerenciamento Escolar

## 📝 Descrição
Sistema desenvolvido em Java para gerenciamento de alunos e disciplinas em uma instituição de ensino. O projeto implementa operações CRUD (Create, Read, Update, Delete) e segue o padrão de arquitetura MVC (Model-View-Controller).

## 🏗️ Estrutura do Projeto

```
src/
├── business/
│   └── services/
│       ├── DisciplineService.java     # Regras de negócio para disciplinas
│       ├── IOService.java            # Serviço de entrada/saída
│       └── StudentService.java       # Regras de negócio para alunos
├── models/
│   ├── entities/
│   │   ├── Discipline.java          # Entidade Disciplina
│   │   └── Student.java             # Entidade Aluno
│   └── repositories/
│       ├── DisciplineRepository.java # Repositório de Disciplinas
│       └── StudentRepository.java    # Repositório de Alunos
└── presentations/
    ├── controllers/
    │   ├── DisciplineController.java # Controlador de Disciplinas
    │   └── StudentController.java    # Controlador de Alunos
    └── views/
        ├── DeleteView.java          # Interface de exclusão
        ├── ListView.java            # Interface de listagem
        ├── Main.java                # Ponto de entrada da aplicação
        ├── MenuView.java            # Menu principal
        ├── RegisterView.java        # Interface de cadastro
        └── UpdateView.java          # Interface de atualização
```

## 🚀 Funcionalidades

### Gerenciamento de Alunos
- Cadastrar novo aluno
- Atualizar dados do aluno
- Remover aluno
- Listar todos os alunos

### Gerenciamento de Disciplinas
- Cadastrar nova disciplina
- Atualizar dados da disciplina
- Remover disciplina
- Listar todas as disciplinas
- Matricular aluno em disciplina
- Desmatricular aluno de disciplina

## 🛠️ Tecnologias Utilizadas
- Java 17
- Padrão MVC
- Programação Orientada a Objetos
- Singleton Pattern (StudentRepository)

## ⚙️ Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 17 ou superior
- Visual Studio Code com extensão "Extension Pack for Java"

### Passos para Execução

1. Clone o repositório:
```bash
git clone https://github.com/jpdevv/sistema-gerenciamento-escolar.git
```

2. Abra o projeto no Visual Studio Code:
```bash
code sistema-gerenciamento-escolar
```

3. Execute a classe Main:
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
   - Controllers: Validação de entrada e direcionamento

2. **Negócio** (`business/`)
   - Services: Regras de negócio e lógica da aplicação
   - IOService: Gerenciamento de entrada/saída

3. **Modelo** (`models/`)
   - Entities: Classes de domínio
   - Repositories: Persistência de dados

## 👥 Padrões de Projeto Utilizados

### MVC (Model-View-Controller)
- **Model**: Entidades e repositórios
- **View**: Classes especializadas em `presentations/views`
- **Controller**: Classes em `presentations/controllers`

### Repository Pattern
- Abstração da persistência de dados
- Implementado em `models/repositories`
- StudentRepository implementa Singleton Pattern

### Singleton Pattern
- Implementado no StudentRepository para garantir instância única

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