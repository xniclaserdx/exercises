
	public class Node<CT> {

		private CT content = null;
		private Node<CT> nextNode = null;

		/**
		 * Ein neues Objekt vom Typ Node<ContentType> wird erschaffen. 
		 * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
		 * 
		 * @param pContent das Inhaltselement des Knotens vom Typ ContentType
		 */
		public Node(CT pContent) {
			content = pContent;
			nextNode = null;
		}

		/**
		 * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
		 * gesetzt.
		 * 
		 * @param pNext der Nachfolger des Knotens
		 */
		public void setNext(Node<CT> pNext) {
			nextNode = pNext;
		}
		
		/**
		 * Liefert das naechste Element des aktuellen Knotens.
		 * 
		 * @return das Objekt vom Typ QueueNode, auf das der aktuelle Verweis zeigt
		 */
		public Node<CT> getNext() {
			return nextNode;
		}

		/**
		 * Liefert das Inhaltsobjekt des Knotens vom Typ ContentType.
		 * 
		 * @return das Inhaltsobjekt des Knotens
		 */
		public CT getContent() {
			return content;
		}
		
	} // class Node
