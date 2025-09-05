import ReactDOM from 'react-dom/client'
import { AppContent } from "./shared/app-content.tsx";
import { BrowserRouter } from "react-router";
import { queryClient } from "./shared/tanstack/tanstack-query-config.tsx";
import "./index.css";
import { QueryClientProvider } from "@tanstack/react-query";

const AppRoot = () => {
    return (
        <QueryClientProvider client={queryClient}>
            <BrowserRouter>
                <AppContent />
            </BrowserRouter>
        </QueryClientProvider>
    )
}

const rootElement = document.getElementById('root') as HTMLElement
ReactDOM.createRoot(rootElement).render(<AppRoot />)
