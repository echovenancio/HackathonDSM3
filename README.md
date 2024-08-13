# Sobre o repositório

Quando você for codar algo, crie um novo braço com:

git checkout -b _nome-do-braço_

E de o push desse braço:

git checkout add _arquivo_
git checkout commit -am "mensagem"
git push origin _nome-do-braço_


# Sobre como usar o script para configurar o banco de dados

Rode o script com a flag -h, ou sem nenhum subcomando para conseguir a mesma mensagem.

-------------------------------------------------------------

Script para configurar o banco de dados do Hackathon.

options:
  -h, --help            show this help message and exit

Sub-comandos:
  {setup,novo,executar,rollback,status}
    setup               Esse subcomandos não possui argumentos, quando
                        executado criara todo ambiente para operar o banco de
                        dados: sqlite3.
    novo                Possui um argumento posicional, que quando alimentado
                        criara uma migração com o valor do argumento.
    executar            Esse subcomando não possui argumentos, quando
                        executado executara todas as migrações pendentes.
    rollback            Possui um argumento posicional, que quando alimentado
                        reverte todas as migrações até e incluindo a migração
                        com o nome do valor do argumento.
    status              Esse subcomando não possui argumentos, quando
                        executado retorna a quantidade de migrações pendentes.

Exemplos:
    setup.py setup # comando para criar o banco de dados
    setup.py novo exemplo # cria uma nova migração com o nome 'exemplo'
    setup.py executar # executa todas as migrações pendentes
    setup.py rollback exemplo # reverte todas as alterações até a migração com nome 'exemplo'
    setup.py status # verifica a quantidade de migrações pendentes.