import React, { useState, useEffect } from 'react';
import BookList from './components/BookList';
import BookForm from './components/BookForm';
import SearchBar from './components/SearchBar';
import './App.css'; // We'll add some basic styling

const API_URL = 'http://localhost:3001/books';

function App() {
  const [books, setBooks] = useState([]);
  const [filteredBooks, setFilteredBooks] = useState([]);
  const [editingBook, setEditingBook] = useState(null);

  // Fetch books on initial render
  useEffect(() => {
    fetch(API_URL)
      .then(res => res.json())
      .then(data => {
        setBooks(data);
        setFilteredBooks(data);
      })
      .catch(error => {
        console.error('Error fetching books:', error);
      });
  }, []);

  // Handle Search
  const handleSearch = (query) => {
    const lowercasedQuery = query.toLowerCase();
    const filtered = books.filter(book =>
      book.title.toLowerCase().includes(lowercasedQuery) ||
      book.author.toLowerCase().includes(lowercasedQuery)
    );
    setFilteredBooks(filtered);
  };

  // Handle Create and Update
  const handleSaveBook = async (book) => {
    if (book.id) { // Update existing book
      const response = await fetch(`${API_URL}/${book.id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(book),
      });
      const updatedBook = await response.json();
      const newBooks = books.map(b => (b.id === updatedBook.id ? updatedBook : b));
      setBooks(newBooks);
      setFilteredBooks(newBooks);
    } else { // Create new book
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ ...book, id: String(Date.now()) }), // Add a temporary ID
      });
      const newBook = await response.json();
      const newBooks = [...books, newBook];
      setBooks(newBooks);
      setFilteredBooks(newBooks);
    }
    setEditingBook(null); // Reset form
  };

  // Handle Delete
  const handleDeleteBook = async (id) => {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    const newBooks = books.filter(b => b.id !== id);
    setBooks(newBooks);
    setFilteredBooks(newBooks);
  };
  
  // Handle Edit
  const handleEditBook = (book) => {
    setEditingBook(book);
  };

  return (
    <div className="app-container">
      <h1>📚 Library Management System</h1>
      <BookForm bookToEdit={editingBook} onSave={handleSaveBook} />
      <SearchBar onSearch={handleSearch} />
      <BookList
        books={filteredBooks}
        onEdit={handleEditBook}
        onDelete={handleDeleteBook}
      />
    </div>
  );
}

export default App;