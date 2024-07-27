import { ToastContainer } from "react-toastify";
import "./App.css";
import 'react-toastify/dist/ReactToastify.css'
import NavBar from './components/NavBar';
import { Route, Routes } from "react-router-dom";
import AllFiles from './components/AllFiles';
import DownloadFile from './components/DownloadFile';
import UploadFile from './components/UploadFile';

function App() {
  return (
    <div className="">
      <NavBar/>
      <Routes>
        <Route path="/" element={<AllFiles/>}/>
        <Route path="/search" element={<DownloadFile/>}/>
        <Route path="/upload" element={<UploadFile/>}/>
      </Routes>
      <ToastContainer/>
    </div>
  );
}

export default App;
