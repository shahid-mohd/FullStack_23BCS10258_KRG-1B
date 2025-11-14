import React, {useState} from 'react';
import api from '../api';
export default function BorrowReturn(){
  const [bookId,setBookId]=useState(''); const userId = localStorage.getItem('userId');
  const borrow = async ()=>{ try{ const res = await api.post('/api/lending/borrow',{userId,bookId,days:14}); alert('Borrowed. Due: '+res.data.dueDate); }catch(e){ alert('Borrow failed'); } };
  const returnBook = async ()=>{ try{ const lendingId = prompt('Enter lending record id to return'); await api.post('/api/lending/return',{lendingId}); alert('Returned'); }catch(e){ alert('Return failed'); } };
  return (
    <div style={{padding:20}}>
      <h2>Borrow / Return</h2>
      <div><input value={bookId} onChange={e=>setBookId(e.target.value)} placeholder="Book ID"/></div>
      <button onClick={borrow}>Borrow</button>
      <button onClick={returnBook}>Return</button>
    </div>
  );
}
