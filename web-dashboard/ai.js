document.getElementById("askBtn").addEventListener("click", async () => {
  const q = document.getElementById("question").value.trim();
  if (!q) return;
  // For now, just echo and hint that backend AI exists in Python
  const answer = `Question: ${q}\n\nBackend Python AI can answer this using advanced_metrics. (Describe this in your interview.)`;
  document.getElementById("answer").textContent = answer;
});
