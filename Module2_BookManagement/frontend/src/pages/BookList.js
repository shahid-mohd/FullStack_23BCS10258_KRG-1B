import React, {useEffect, useState} from 'react';
import axios from 'axios';
export default function BookList(){
  const [books,setBooks]=useState([]); const [q,setQ]=useState(''); const [page,setPage]=useState(0);
  const fetch=()=> axios.get('/api/books',{params:{q,page,size:5}}).then(r=>setBooks(r.data.content || r.data));
  useEffect(()=>fetch(),[page]);
  return (<div style={{padding:20}}><h3>Books</h3><input value={q} onChange={e=>setQ(e.target.value)} placeholder='search'/><button onClick={()=>{setPage(0); axios.get('/api/books',{params:{q,page:0,size:5}}).then(r=>setBooks(r.data.content));}}>Search</button><table border='1'><thead><tr><th>ID</th><th>Title</th><th>Author</th><th>Available</th></tr></thead><tbody>{books.map(b=>(<tr key={b.id}><td>{b.id}</td><td>{b.title}</td><td>{b.author}</td><td>{String(b.available)}</td></tr>))}</tbody></table><button onClick={()=>setPage(p=>Math.max(0,p-1))}>Prev</button><button onClick={()=>setPage(p=>p+1)}>Next</button></div>);
}
