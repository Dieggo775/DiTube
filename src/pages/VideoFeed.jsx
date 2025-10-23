import { useEffect, useState } from 'react';
import api from '../services/api';

export default function VideoFeed() {
  const [videos, setVideos] = useState([]);

  useEffect(() => {
    api.get('/videos')
      .then(response => setVideos(response.data))
      .catch(error => console.error('Erro ao buscar vídeos:', error));
  }, []);

  return (
    <div>
      <h1>Vídeos</h1>
      <ul>
        {videos.map(video => (
          <li key={video.id}>{video.title}</li>
        ))}
      </ul>
    </div>
  );
}