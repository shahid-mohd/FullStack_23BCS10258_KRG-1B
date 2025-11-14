import React,{useState,useEffect} from 'react';
import axios from 'axios';
export default function Fines(){
  const [fines,setFines]=useState([]); const userId = prompt('Enter your userId for demo');
  useEffect(()=>{ if(userId) axios.get('/api/fines/user/'+userId).then(r=>setFines(r.data)).catch(()=>{}); },[userId]);
  const pay=async(id)=>{ await axios.post('/api/fines/pay',{id}); setFines(f=>f.filter(x=>x.id!==id)); alert('Paid'); };
  return (<div style={{padding:20}}><h3>Your Fines</h3><ul>{fines.map(f=>(<li key={f.id}>₹{f.amount} - Paid:{String(f.paid)} <button onClick={()=>pay(f.id)}>Pay</button></li>))}</ul></div>);
}
