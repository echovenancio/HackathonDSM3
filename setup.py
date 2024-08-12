import sqlite3
import os

migrations_dir = 'migrations'

def create_db():
    conn  = None
    try:
        conn = sqlite3.connect("database.db")
    except Exception as e:
        import sys
        sys.stderr.write(f"Erro criando Banco de Dados: {e}")
        sys.exit(1)
    else:
        return conn

def run_migrations(conn):
    try:
        migrations= os.listdir(migrations_dir)
    except Exception as e:
        os.mkdir(migrations_dir)
        return
    for file in migration:
        with open(f'{migrations_dir}/{file}') as f:
            try:
                s = f.read()
                conn.execute(s)
            except Exception:
                import sys
                sys.stderr.write(f'Erro executando migrações: {e}')
                sys.exit(1)

if __name__ == '__main__':
    conn = create_db()
    run_migrations(conn)