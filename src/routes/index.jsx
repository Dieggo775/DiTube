import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from '../pages/LoginPage';
import VideoFeed from '../pages/VideoFeed';
import PlaylistPage from '../pages/PlaylistPage';

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<VideoFeed />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/playlists" element={<PlaylistPage />} />
      </Routes>
    </BrowserRouter>
  );
}