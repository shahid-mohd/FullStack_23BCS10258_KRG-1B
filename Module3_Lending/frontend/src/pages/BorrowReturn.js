import React, {useState,useEffect} from 'react';
import axios from 'axios';
export default function BorrowReturn(){
  const [bookId,setBookId]=useState(''); const [books,setBooks]=useState([]);
  useEffect(()=>{ axios.get('/api/books').then(r=>setBooks(r.data)).catch(()=>{}); },[]);
  const borrow=async()=>{ try{ const userId = prompt('Your userId'); await axios.post('/api/lending/borrow',{userId,bookId,days:14}); alert('Borrowed'); }catch(e){ alert('Error'); } };
  const ret=async()=>{ const lendingId = prompt('Lending id'); await axios.post('/api/lending/return',{lendingId}); alert('Returned'); };
  return (<div style={{padding:20}}><h3>Borrow/Return</h3><input value={bookId} onChange={e=>setBookId(e.target.value)} placeholder='book id'/><button onClick={borrow}>Borrow</button><button onClick={ret}>Return</button><h4>Available Books</h4><ul>{books.map(b=>(<li key={b.id}>{b.title} - {String(b.available)}</li>))}</ul></div>);
}
