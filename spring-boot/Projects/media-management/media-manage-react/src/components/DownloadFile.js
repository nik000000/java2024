import React, { useState} from 'react';
import axios from 'axios';
import Image from './Image';

const FileDownload = () => {
  const [file, setFile] = useState(null);
  const [fileId, setFileId] = useState([]);
  const [selectedImage, setSelectedImage] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false);

  function changeHandler(event){
    setFileId(event.target.value)
  }


  async function fetchImage(event){
    try {
      const response = await axios.get('/api/v1/file/download/'+fileId);
      const data = await response.data;
      setFile(data);
    } catch (error) {
      setFile(null);
      console.error('Error fetching the image:', error);
    }
  }
  const handleCloseModal = () => {
    setIsModalOpen(false);
    setTimeout(() => {
      setSelectedImage(null);
    }, 300); // Duration matches the transition duration
  };
  return (
    <div className="flex flex-col gap-5 justify-center items-center h-screen] mt-[80px]">
      <input type='text' placeholder='enter image id' onChange={changeHandler} className="border-[1px] p-2 rounded-md w-[400px]"/>
      <button onClick={fetchImage} className="bg-blue-500 text-white font-bold py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300 w-[400px]">Get Image</button>
      {
        file ? (<Image image={file} setSelectedImage={setSelectedImage} setIsModalOpen={setIsModalOpen}/>) : (<div>Not Found</div>)
      }
      {selectedImage && (
            <div
              className={`fixed inset-0 flex items-center justify-center bg-black bg-opacity-75 z-50 transition-opacity duration-300 ${isModalOpen ? 'opacity-100' : 'opacity-0'}`}
              onClick={handleCloseModal}
            >
              <div className={`relative transition-transform duration-300 transform ${isModalOpen ? 'scale-100' : 'scale-0'}`}>
                <span className="absolute top-4 right-4 text-black text-4xl cursor-pointer" onClick={handleCloseModal}>&times;</span>
                <img
                  className="max-w-full max-h-full"
                  src={`data:image/jpeg;base64,${selectedImage}`}
                  alt="Enlarged"
                  onClick={(e) => e.stopPropagation()} // Prevent closing the modal when clicking on the image
                />
              </div>
            </div>
          )}
      
    </div>
  );
};

export default FileDownload;