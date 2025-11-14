import React, {useEffect, useState} from 'react';
import api from '../api';
export default function Reports(){
  const [data,setData]=useState(null);
  useEffect(()=>{ api.get('/api/reports/summary').then(r=>setData(r.data)).catch(()=>{}); },[]);
  return (
    <div style={{padding:20}}>
      <h2>Reports</h2>
      {data ? <pre>{JSON.stringify(data,null,2)}</pre> : 'Loading...'}
    </div>
  );
}
