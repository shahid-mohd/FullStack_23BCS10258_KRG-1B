const body = document.body
const toggleBtn = document.getElementById("theme-toggle")
const sidebarToggle = document.getElementById("sidebar-toggle")
const sidebar = document.getElementById("sidebar")

if (localStorage.getItem("theme") === "dark") {
  body.classList.add("dark")
  toggleBtn.textContent = "☀️"
} else {
  toggleBtn.textContent = "🌙"
}

toggleBtn.addEventListener("click", () => {
  body.classList.toggle("dark")
  if (body.classList.contains("dark")) {
    localStorage.setItem("theme", "dark")
    toggleBtn.textContent = "☀️"
  } else {
    localStorage.setItem("theme", "light")
    toggleBtn.textContent = "🌙"
  }
})

sidebarToggle.addEventListener("click", () => {
  sidebar.classList.toggle("active")
})
