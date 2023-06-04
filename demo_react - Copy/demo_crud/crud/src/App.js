// import logo from './logo.svg';
import './App.css';
import Home from '../src/Components/Home';
import { BrowserRouter , Routes, Route} from 'react-router-dom';
import Add from '../src/Components/Add';
import Update from './Components/Update';


function App() {
  return (
   <div>
     <BrowserRouter>
     
     <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/add" element={<Add/>}/>
      <Route path="/update/:id" element={<Update/>}/>
     </Routes>
     
     </BrowserRouter>
    </div>
  );
}

export default App;
