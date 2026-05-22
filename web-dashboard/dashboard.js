const API_BASE = "http://localhost:8080";

async function loadTeamKpi() {
  const res = await fetch(`${API_BASE}/teams/kpi`);
  const data = await res.json();

  const labels = data.map(d => d.team);
  const net = data.map(d => d.netRating);

  new Chart(document.getElementById("teamChart"), {
    type: "bar",
    data: {
      labels,
      datasets: [{
        label: "Net Rating",
        data: net,
        backgroundColor: "rgba(54, 162, 235, 0.6)"
      }]
    }
  });
}

async function loadTopPlayers() {
  const res = await fetch(`${API_BASE}/players/top`);
  const data = await res.json();
  const tbody = document.querySelector("#playersTable tbody");
  tbody.innerHTML = "";
  data.forEach(p => {
    const tr = document.createElement("tr");
    tr.innerHTML = `
      <td>${p.playerName}</td>
      <td>${p.team}</td>
      <td>${p.per.toFixed(1)}</td>
      <td>${(p.ts * 100).toFixed(1)}%</td>
    `;
    tbody.appendChild(tr);
  });
}

window.addEventListener("DOMContentLoaded", () => {
  loadTeamKpi();
  loadTopPlayers();
});
