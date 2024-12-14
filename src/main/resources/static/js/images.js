const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const upload = document.getElementById('upload');
const rotateButton = document.getElementById('rotate');
const zoomInButton = document.getElementById('zoomIn');
const zoomOutButton = document.getElementById('zoomOut');
const cropButton = document.getElementById('crop');

let img = new Image();
let scale = 1;
let rotation = 0;

upload.addEventListener('change', (e) => {
    const file = e.target.files[0];
    const reader = new FileReader();

    reader.onload = (event) => {
        img.src = event.target.result;
        img.onload = () => {
            drawImage();
        };
    };

    if (file) {
        reader.readAsDataURL(file);
    }
});

rotateButton.addEventListener('click', () => {
    rotation += 90;
    drawImage();
});

zoomInButton.addEventListener('click', () => {
    scale += 0.1;
    drawImage();
});

zoomOutButton.addEventListener('click', () => {
    scale = Math.max(0.1, scale - 0.1);
    drawImage();
});

cropButton.addEventListener('click', () => {
    const croppedData = ctx.getImageData(0, 0, 500, 500); // Change the cropping area as needed
    canvas.width = 500; // Set canvas width to cropped width
    canvas.height = 500; // Set canvas height to cropped height
    ctx.putImageData(croppedData, 0, 0);
});

// Function to draw the image on the canvas
function drawImage() {
    // Clear the canvas
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Save the context state
    ctx.save();

    // Translate and rotate the context
    ctx.translate(canvas.width / 2, canvas.height / 2);
    ctx.rotate(rotation * Math.PI / 180);
    ctx.scale(scale, scale);
    ctx.drawImage(img, -img.width / 2, -img.height / 2);

    // Restore the context to its original state
    ctx.restore();
}
