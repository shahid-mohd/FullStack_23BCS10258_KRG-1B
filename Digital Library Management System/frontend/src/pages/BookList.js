import React, {useEffect, useState} from 'react';
import api from '../api';

export default function BookList(){
  const [books,setBooks]=useState([]);
  useEffect(()=>{ api.get('/api/books').then(r=>setBooks(r.data.content || r.data)).catch(()=>{}); },[]);
  return (
    <div style={{padding:20}}>
      <h2>Books</h2>
      <table border="1" cellPadding="6"><thead><tr><th>ID</th><th>Title</th><th>Author</th><th>Available</th></tr></thead>
      <tbody>
        {books.map(b=>(
          <tr key={b.id}><td>{b.id}</td><td>{b.title}</td><td>{b.author}</td><td>{String(b.available)}</td></tr>
        ))}
      </tbody></table>
    </div>
  );
}
