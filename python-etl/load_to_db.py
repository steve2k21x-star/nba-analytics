import os
import pandas as pd
from sqlalchemy import create_engine

DB_URL = os.getenv("DATABASE_URL", "postgresql://nba_user:nba_pass@localhost:5432/nba_db")

def main():
    engine = create_engine(DB_URL)

    games = pd.read_csv("games.csv")
    stats = pd.read_csv("player_stats.csv")
    adv = pd.read_csv("advanced_metrics.csv")

    games.to_sql("raw_games", engine, if_exists="append", index=False)
    stats.to_sql("player_stats", engine, if_exists="append", index=False)
    adv.to_sql("advanced_metrics", engine, if_exists="append", index=False)

    print("Loaded raw_games, player_stats, advanced_metrics into Postgres")

if __name__ == "__main__":
    main()
