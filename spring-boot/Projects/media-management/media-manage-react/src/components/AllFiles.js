import axios from 'axios';
import {useState, useEffect} from 'react';
import './AllFiles.css';
import Image from './Image';

function AllFiles(){
    const [images, setImages] = useState([]);
    const [selectedImage, setSelectedImage] = useState(null);
    const [isModalOpen, setIsModalOpen] = useState(false);
  

    async function getFiles(){
        try {
            const response = await axios.get('/api/v1/file/all');
            const allImages = await response.data;
            setImages(allImages);
          } catch (error) {
            setImages([]);
            console.error('Error fetching the image:', error.response.data);
          }
    }

    useEffect(() => {
        getFiles();
    }, []);
    
      const handleCloseModal = () => {
        setIsModalOpen(false);
        setTimeout(() => {
          setSelectedImage(null);
        }, 300); // Duration matches the transition duration
      };
    
      return (
        <div className="p-4 ">
          <h1 className="text-2xl font-bold mb-4 text-center">All the images</h1>
          <div className="flex flex-wrap gap-4 mx-auto justify-center">
            {images.length > 0 ? (
              images.map((image)=>{
                return (<Image image={image} setSelectedImage={setSelectedImage} setIsModalOpen={setIsModalOpen}/>)
              })
            ) : (
              <p>Loading...</p>
            )}
          </div>
    
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
    

export default AllFiles;