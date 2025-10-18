import React from 'react';

function BookItem({ book, onEdit, onDelete }) {
  return (
    <div className="book-item">
      <div className="book-item-info">
        <h3>{book.title}</h3>
        <p className="author">by {book.author}</p>
        <div className="book-details">
          {book.year && <span className="detail-badge">📅 {book.year}</span>}
          {book.genre && <span className="detail-badge">📚 {book.genre}</span>}
          {book.pages && <span className="detail-badge">📄 {book.pages} pages</span>}
        </div>
      </div>
      <div className="book-item-actions">
        <button onClick={() => onEdit(book)}>✏️ Edit</button>
        <button onClick={() => onDelete(book.id)}>🗑️ Delete</button>
      </div>
    </div>
  );
}

export default BookItem;