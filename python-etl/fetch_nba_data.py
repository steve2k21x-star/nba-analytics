import requests
import pandas as pd
from datetime import date

BASE = "https://www.balldontlie.io/api/v1"

def fetch_games_for_date(d: str):
    resp = requests.get(f"{BASE}/games", params={"dates[]": d, "per_page": 100})
    return resp.json()["data"]

def fetch_stats_for_game(game_id: int):
    resp = requests.get(f"{BASE}/stats", params={"game_ids[]": game_id, "per_page": 100})
    return resp.json()["data"]

def main(target_date: str | None = None):
    if target_date is None:
        target_date = date.today().isoformat()

    games = fetch_games_for_date(target_date)
    games_rows, stats_rows = [], []

    for g in games:
        games_rows.append({
            "game_id": g["id"],
            "game_date": g["date"][:10],
            "home_team": g["home_team"]["full_name"],
            "visitor_team": g["visitor_team"]["full_name"],
            "home_score": g["home_team_score"],
            "visitor_score": g["visitor_team_score"],
        })
        stats = fetch_stats_for_game(g["id"])
        for s in stats:
            p = s["player"]
            t = s["team"]
            stats_rows.append({
                "game_id": g["id"],
                "player_id": p["id"],
                "player_name": f"{p['first_name']} {p['last_name']}",
                "team": t["full_name"],
                "pts": s["pts"],
                "reb": s["reb"],
                "ast": s["ast"],
                "stl": s["stl"],
                "blk": s["blk"],
                "tov": s["turnover"],
                "fga": s["fga"],
                "fta": s["fta"],
            })

    pd.DataFrame(games_rows).to_csv("games.csv", index=False)
    pd.DataFrame(stats_rows).to_csv("player_stats.csv", index=False)
    print(f"Fetched {len(games_rows)} games and {len(stats_rows)} player stats for {target_date}")

if __name__ == "__main__":
    main()
