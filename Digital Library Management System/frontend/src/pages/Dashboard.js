import React, {useEffect, useState} from 'react';
import api from '../api';
export default function Dashboard(){
  const [s,setS]=useState(null);
  useEffect(()=>{ api.get('/api/reports/summary').then(r=>setS(r.data)).catch(()=>{}); },[]);
  return (
    <div style={{padding:20}}>
      <h2>Dashboard</h2>
      {s ? (
        <div>
          <p>Total books: {s.totalBooks}</p>
          <p>Lent books: {s.lentBooks}</p>
          <p>Overdue: {s.overdue}</p>
          <p>Fine Collected: ₹{s.fineCollected}</p>
        </div>
      ) : 'Loading...'}
    </div>
  );
}
