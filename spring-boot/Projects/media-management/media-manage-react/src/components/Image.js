import { IoMdDownload } from "react-icons/io";
import { MdDelete } from "react-icons/md";

function Image({image, setSelectedImage, setIsModalOpen}){
    const handleImageClick = (imageData) => {
        setSelectedImage(imageData);
        setIsModalOpen(true);
    };
    const handleDownload = (imageData, imageName) => {
        const link = document.createElement('a');
        link.href = `data:image/jpeg;base64,${imageData}`;
        link.download = imageName;
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
      };

      function handleDelete(){
        console.log('delete: '+image.id)
      }

    return (
        <div key={image.id} className="relative">
            <img
            src={`data:image/jpeg;base64,${image.fileBytes}`}
            alt={image.name}
            className="w-48 h-48 object-cover cursor-pointer transition-transform transform hover:scale-110 duration-[0.5s]"
            onClick={() => handleImageClick(image.fileBytes)}
            />
            <IoMdDownload className="absolute bottom-2 right-2 w-[30px] h-[30px] cursor-pointer"
            onClick={() => handleDownload(image.fileBytes, image.name)}/>
            <MdDelete onClick={handleDelete} className="absolute top-1 right-1 w-[25px] h-[25px] cursor-pointer text-red-900"/>
        </div>
    );
}

export default Image;