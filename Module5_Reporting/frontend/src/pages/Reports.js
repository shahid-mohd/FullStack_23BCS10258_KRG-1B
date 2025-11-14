import React,{useEffect,useState} from 'react';
import axios from 'axios';
export default function Reports(){
  const [data,setData]=useState(null);
  useEffect(()=>{ axios.get('/api/reports/summary').then(r=>setData(r.data)).catch(()=>{}); },[]);
  return (<div style={{padding:20}}><h3>Reports</h3><pre>{data?JSON.stringify(data,null,2):'Loading...'}</pre></div>);
}
