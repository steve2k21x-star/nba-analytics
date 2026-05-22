from sqlalchemy import create_engine, text
import os

DB_URL = os.getenv("DATABASE_URL", "postgresql://nba_user:nba_pass@localhost:5432/nba_db")

def answer_question(q: str) -> str:
    engine = create_engine(DB_URL)
    with engine.connect() as conn:
        res = conn.execute(text("""
            SELECT player_name, team, per, ts
            FROM advanced_metrics
            ORDER BY per DESC
            LIMIT 5
        """))
        top = [f"{r.player_name} ({r.team}) PER={r.per:.1f}, TS={r.ts:.3f}" for r in res]
    return f"Question: {q}\nTop players by PER:\n" + "\n".join(top)

if __name__ == "__main__":
    print(answer_question("Who is playing best right now?"))
