import React, { useState, useRef } from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';

const FileUpload = () => {
  const [file, setFile] = useState(null);
  const fileInputRef = useRef(null);

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleUpload = async (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append('file', file);

    try {
      const response = await axios.post('/api/v1/file/upload', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      toast.success(`File uploaded successfully`);
      // Clear the file input
      fileInputRef.current.value = "";
      setFile(null);
    } catch (error) {
      setFile(null);
      console.error('Error uploading file:', error);
      toast.error('Failed to upload file.');
    }
  };

  return (
    <div className="flex flex-col items-center justify-center bg-gray-100 p-4">
      <h1 className="text-2xl font-bold mb-4">Upload File</h1>
      <form onSubmit={handleUpload} className="flex flex-col items-center bg-white p-6 rounded-lg shadow-md">
        <input 
          type="file" 
          onChange={handleFileChange} 
          required 
          ref={fileInputRef}
          className="mb-4 p-2 border border-gray-300 rounded-lg"
        />
        <button 
          type="submit" 
          className="bg-blue-500 text-white font-bold py-2 px-4 rounded-lg hover:bg-blue-700 transition duration-300"
        >
          Upload
        </button>
      </form>
    </div>
  );
};

export default FileUpload;
