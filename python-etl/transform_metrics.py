import pandas as pd

def true_shooting(pts, fga, fta):
    denom = 2 * (fga + 0.44 * fta)
    return pts / denom if denom else 0

def simple_per(pts, reb, ast, stl, blk, tov):
    return pts + reb + ast + stl + blk - tov

def compute_advanced(stats_csv: str, out_csv: str):
    df = pd.read_csv(stats_csv)
    df["ts"] = df.apply(lambda r: true_shooting(r["pts"], r["fga"], r["fta"]), axis=1)
    df["per"] = df.apply(lambda r: simple_per(r["pts"], r["reb"], r["ast"], r["stl"], r["blk"], r["tov"]), axis=1)
    df[["game_id","player_id","player_name","team","ts","per"]].to_csv(out_csv, index=False)
    print(f"Wrote advanced metrics to {out_csv}")
