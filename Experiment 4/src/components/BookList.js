import React from 'react';
import BookItem from './BookItem';

function BookList({ books, onEdit, onDelete }) {
  return (
    <div className="book-list">
      {books.length > 0 ? (
        books.map(book => (
          <BookItem key={book.id} book={book} onEdit={onEdit} onDelete={onDelete} />
        ))
      ) : (
        <p>No books found. Try adding one!</p>
      )}
    </div>
  );
}

export default BookList;