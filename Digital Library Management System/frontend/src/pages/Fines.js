import React, {useEffect, useState} from 'react';
import api from '../api';
export default function Fines(){
  const [fines,setFines]=useState([]);
  const userId = localStorage.getItem('userId');
  useEffect(()=>{ if(userId) api.get('/api/fines/user/'+userId).then(r=>setFines(r.data)).catch(()=>{}); },[userId]);
  const pay = async (id)=>{ await api.post('/api/fines/pay',{id}); alert('Paid'); setFines(f=>f.filter(x=>x.id!==id)); };
  return (
    <div style={{padding:20}}>
      <h2>Your Fines</h2>
      <ul>{fines.map(f=> (<li key={f.id}>₹{f.amount} - Paid: {String(f.paid)} <button onClick={()=>pay(f.id)}>Pay</button></li>))}</ul>
    </div>
  );
}
