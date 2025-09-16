const products = [
  { id: 1, name: "Smartphone", category: "electronics"},
  { id: 2, name: "Laptop", category: "electronics"},
  { id: 3, name: "Smartwatch", category: "electronics"},
  { id: 4, name: "Headphones", category: "electronics"},
  { id: 5, name: "Camera", category: "electronics"},

  { id: 6, name: "Jeans", category: "clothing"},
  { id: 7, name: "T-Shirt", category: "clothing"},
  { id: 8, name: "Jacket", category: "clothing"},
  { id: 9, name: "Shoes", category: "clothing"},
  { id: 10, name: "Dress", category: "clothing"},

  { id: 11, name: "Novel - Fiction", category: "books"},
  { id: 12, name: "Textbook - Science", category: "books"},
  { id: 13, name: "Cookbook", category: "books"},
  { id: 14, name: "History Book", category: "books"},
  { id: 15, name: "Children’s Story Book", category: "books"}
]

const categorySelect = document.getElementById("category")
const productList = document.getElementById("product-list")
const feedback = document.getElementById("feedback")

function renderProducts(items) {
  if (items.length === 0) {
    productList.innerHTML = ""
    feedback.textContent = "No products found."
  } else {
    feedback.textContent = ""
    productList.innerHTML = items
      .map(item => `
        <div class="product-card">
          <img src="${item.img}" alt="${item.name}">
          <h3>${item.name}</h3>
          <p>Category: ${item.category}</p>
        </div>
      `)
      .join("")
  }
}

function filterProducts() {
  const selected = categorySelect.value
  const filtered = selected === "all"
    ? products
    : products.filter(p => p.category === selected)
  renderProducts(filtered)
}

categorySelect.addEventListener("change", filterProducts)
renderProducts(products)
