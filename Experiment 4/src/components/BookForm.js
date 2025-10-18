import React, { useState, useEffect } from 'react';

const initialFormState = { id: null, title: '', author: '', year: '', genre: '', pages: '' };

function BookForm({ bookToEdit, onSave }) {
  const [book, setBook] = useState(initialFormState);

  // Pre-fill form if a book is selected for editing
  useEffect(() => {
    if (bookToEdit) {
      setBook(bookToEdit);
    } else {
      setBook(initialFormState);
    }
  }, [bookToEdit]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setBook({ ...book, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!book.title || !book.author) return;
    onSave(book);
    setBook(initialFormState); // Reset form after submission
  };

  return (
    <form onSubmit={handleSubmit} className="book-form">
      <h2>{book.id ? 'Edit Book' : 'Add New Book'}</h2>
      <div className="form-grid">
        <input
          type="text"
          name="title"
          placeholder="📖 Book Title"
          value={book.title}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="author"
          placeholder="✍️ Author Name"
          value={book.author}
          onChange={handleChange}
          required
        />
        <input
          type="number"
          name="year"
          placeholder="📅 Publication Year"
          value={book.year}
          onChange={handleChange}
          min="1000"
          max="2100"
        />
        <input
          type="text"
          name="genre"
          placeholder="📚 Genre"
          value={book.genre}
          onChange={handleChange}
        />
        <input
          type="number"
          name="pages"
          placeholder="📄 Number of Pages"
          value={book.pages}
          onChange={handleChange}
          min="1"
        />
      </div>
      <button type="submit">
        {book.id ? '💾 Update Book' : '➕ Add Book'}
      </button>
    </form>
  );
}

export default BookForm;