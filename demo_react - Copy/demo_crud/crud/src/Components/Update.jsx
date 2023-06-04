import axios  from 'axios';
import { useRef, useState, useEffect} from 'react';
import { useNavigate , useParams } from 'react-router-dom';
import '../Styles/update.css';

function Update() {

    let navigate = useNavigate();
   
    let name = useRef();
    let age = useRef();
    let location = useRef();
    let gender = useRef();
    let salary = useRef();
    
    let {id} = useParams();
    console.log(id);
    let submitHandler=(e)=>{
        e.preventDefault();
        
        let add = {
            name: name.current.value,
            age: age.current.value,
            location : location.current.value,
            gender : gender.current.value,
            salary: salary.current.value
          }

          axios("http://localhost:8080/employee/update",{
                method:"PUT",
                data:add,
                body:JSON.stringify(add)
            }).then((res)=>{
                        console.log(res); 
                        alert("Data updated.!"); 
                        navigate("/");
                        })
        .catch((err)=>{alert("User not found"); console.log(err);})
    }


    let[data,setData] = useState({})
    useEffect(()=>{
        axios.get("http://localhost:8080/employee/getbyid/"+id)
        .then((res)=>{console.log(res);

            // if(res.data.id==true)
            // {  
            //     setData(res.data);
            // }
                setData(res.data);
              console.log(res.data); })
              .catch((err)=>{alert("no data found"); console.log(err); navigate("/");})
    },[])
   
    return ( 
        <>

        <form onSubmit={submitHandler}>
        <h1>{id}</h1>
        <label>Name : </label>
            <input type="text" value={data.name} ref={name}/>
        <label>Age : </label>
            <input type="number" value={data.age} onChange={(e)=>setData(e.target.value)} placeholder="Age" ref={age}/>
        <label>Location : </label>
            <input type="text" value={data.location} onChange={(e)=>setData(e.target.value)} placeholder="location" ref={location}/>
        <label>Gender : </label>
            <input type="text" value={data.gender} onChange={(e)=>setData(e.target.value)} placeholder="gender" ref={gender}/>
        <label>Salary : </label>
            <input type="number" value={data.salary} onChange={(e)=>setData(e.target.value)} placeholder="Salary" ref={salary}/>
       <input type="submit"/>
        </form>
        
        
        </>
     );
}

export default Update;